package mindustry.ai.types;

import arc.math.*;
import mindustry.ai.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.world.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class GroundAI extends AIController{

    @Override
    public void updateMovement(){

        Building core = unit.closestEnemyCore();
        Teamc target= target(unit.x, unit.y, unit.type.range, true, true);
        // Teamc target= unit.closestTarget(unit.team, unit.x, unit.y, unit.type.range);
        System.out.println("core: "+core);
        System.out.println("target "+target);
        // if (target != null) {
            
        //     if (target instanceof Building) {
        //         Building building = (Building) target;
        //         if (building.team != unit.team) {
        //             System.out.println("target is Enemy Building");
        //             // if (building.health < building.maxHealth) {
        //                 System.out.println("Building health " + building.health + " max Health " + building.maxHealth);
        //                 System.out.println("Building " + building.x + " " + building.y);
        //                 // moveTo(building, building.hitSize() / 2f + unit.hitSize() / 2f + 15f, 50f);
        //                 moveTo(building, unit.type.range, 50f);

        //                 unit.lookAt(building);
        //                 for(var mount : unit.mounts){
        //                     if(mount.weapon.controllable && mount.weapon.bullet.collidesGround){
        //                         mount.target = target;
        //                     }
        //                 }
        //         }
        //     }

        // //         if( unit.within(target, unit.range() / 1.3f )){
        // //     // target = ;
        // //     System.out.println("target is in range");
        // //     for(var mount : unit.mounts){
        // //         if(mount.weapon.controllable && mount.weapon.bullet.collidesGround){
        // //             mount.target = target;
        // //         }
        // //     }
        // // }

        //     else {
        //         System.out.println("unit hit size "+unit.hitSize() +" unit range "+unit.type.range);
        //         if(unit.within(target, (unit.hitSize ) * 1.0f)){
        //             //circle target
        //             System.out.println("target is within range");
        //             unit.movePref(vec.set(target).sub(unit).rotate(90f).setLength(unit.speed()));
        //         }
        //         System.out.println("target is enemy");
        //         // moveTo(target, unit.hitSize(), 50f);
        //         unit.lookAt(target);
        //     }
        //     // faceTarget();
        // }
        if((target != null && !unit.within(target, unit.type.range*0.5f)) && command() == UnitCommand.attack){
                    boolean move = false;

            // if(state.rules.waves && unit.team == state.rules.defaultTeam){
            //     Tile spawner = getClosestSpawner();
            //     if(spawner != null && unit.within(spawner, state.rules.dropZoneRadius + 120f)) move = false;
            // }
            System.out.println("move: "+move+" unit.move "+unit.team+" unit.type.range "+unit.type.range);
            if(move) pathfind(Pathfinder.fieldCore);
        }
        else if(core != null && unit.within(core, unit.range() / 1.3f + core.block.size * tilesize / 2f)){
            target = core;
            for(var mount : unit.mounts){
                if(mount.weapon.controllable && mount.weapon.bullet.collidesGround){
                    mount.target = core;
                }
            }
        }
        
        

        else if((core == null || !unit.within(core, unit.type.range*0.5f)) && command() == UnitCommand.attack){
            boolean move = true;

            if(state.rules.waves && unit.team == state.rules.defaultTeam){
                Tile spawner = getClosestSpawner();
                if(spawner != null && unit.within(spawner, state.rules.dropZoneRadius + 120f)) move = false;
            }
            System.out.println("move: "+move+" unit.move "+unit.team+" unit.type.range "+unit.type.range);
            if(move) pathfind(Pathfinder.fieldCore);
        }

        if(command() == UnitCommand.rally){
            
            // Teamc target = targetFlag(unit.x, unit.y, BlockFlag.rally, false);
            target = targetFlag(unit.x, unit.y, BlockFlag.rally, false);

            if(target != null && !unit.within(target, 70f)){
                pathfind(Pathfinder.fieldRally);
            }
        }

        if(unit.type.canBoost && unit.elevation > 0.001f && !unit.onSolid()){
            unit.elevation = Mathf.approachDelta(unit.elevation, 0f, unit.type.riseSpeed);
        }

        faceTarget();
    }
}
