package mindustry.ai.types;

import arc.math.*;
import mindustry.ai.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.world.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class GroundAI extends AIController{
<<<<<<< Updated upstream

    @Override
    public void updateMovement(){
=======
    Teamc prevTarget = null;

    @Override
    public void updateMovement(){

        Building core = unit.closestEnemyCore();
        Teamc target= target(unit.x, unit.y, unit.type.range, true, true);
        // Teamc target= unit.closestTarget(unit.team, unit.x, unit.y, unit.type.range);
        // System.out.println("core: "+core);
        // System.out.println("target "+target);
        Unit friend = closestFriendly2(unit, unit.x, unit.y, unit.type.range/2f, true, true);
        if (friend!=null  && unit.type.range > friend.type.range) {
            // target = target(closest.x, closest.y, closest.type.range, true, true);
            System.out.println("Closest Friendly unit "+unit.type.range+" "+friend.type.range);
        }
        int rangeToDetect = 120;
        int dist = -1;
        boolean neighborInRange[] = new boolean[] { false, false, false, false, false, false, false, false, false };
        int[] neighborDist = new int[9];
        Teamc targetInRange = target(unit.x, unit.y, rangeToDetect, true, true);
        System.out.println("prevTarget: " + prevTarget);
        System.out.println("prevTragetInRange: " + checkTarget(prevTarget, unit.x, unit.y, rangeToDetect));
        if (target(unit.x, unit.y, rangeToDetect + 5, true, true) != core) {
            int[][] neighbor = new int[][] {
                    { -1, -1 }, { 0, -1 }, { 1, -1 },
                    { -1, 0 }, { 1, 0 },
                    { -1, 1 }, { 0, 1 }, { 1, 1 }
            };
            for (int i = rangeToDetect; i >= 0; i--)
                if (target(unit.x, unit.y, i, true, true) == null) {
                    neighborDist[8] = i + 1;
                    break;
                }
            for (int i = rangeToDetect; i >= 0; i--)
                if (target(unit.x + neighbor[0][0], unit.y + neighbor[0][1], i, true, true) == null) {
                    neighborDist[0] = i + 1;
                    break;
                }
            for (int i = rangeToDetect; i >= 0; i--)
                if (target(unit.x + neighbor[1][0], unit.y + neighbor[1][1], i, true, true) == null) {
                    neighborDist[1] = i + 1;
                    break;
                }

            for (int i = rangeToDetect; i >= 0; i--)
                if (target(unit.x + neighbor[2][0], unit.y + neighbor[2][1], i, true, true) == null) {
                    neighborDist[2] = i + 1;
                    break;
                }

            for (int i = rangeToDetect; i >= 0; i--)
                if (target(unit.x + neighbor[3][0], unit.y + neighbor[3][1], i, true, true) == null) {
                    neighborDist[3] = i + 1;
                    break;
                }

            for (int i = rangeToDetect; i >= 0; i--)
                if (target(unit.x + neighbor[4][0], unit.y + neighbor[4][1], i, true, true) == null) {
                    neighborDist[4] = i + 1;
                    break;
                }

            for (int i = rangeToDetect; i >= 0; i--)
                if (target(unit.x + neighbor[5][0], unit.y + neighbor[5][1], i, true, true) == null) {
                    neighborDist[5] = i + 1;
                    break;
                }

            for (int i = rangeToDetect; i >= 0; i--)
                if (target(unit.x + neighbor[6][0], unit.y + neighbor[6][1], i, true, true) == null) {
                    neighborDist[6] = i + 1;
                    break;
                }

            for (int i = rangeToDetect; i >= 0; i--)
                if (target(unit.x + neighbor[7][0], unit.y + neighbor[7][1], i, true, true) == null) {
                    neighborDist[7] = i + 1;
                    break;
                }

            // neighborDist[0]= Math.sqrt(Math.pow(unit.x- target.x))
            if (target(unit.x + neighbor[0][0], unit.y + neighbor[0][1], rangeToDetect, true, true) != null) {
                neighborInRange[0] = true;
            }
            if (target(unit.x + neighbor[1][0], unit.y + neighbor[1][1], rangeToDetect, true, true) != null) {
                neighborInRange[1] = true;
            }
            if (target(unit.x + neighbor[2][0], unit.y + neighbor[2][1], rangeToDetect, true, true) != null) {
                neighborInRange[2] = true;
            }
            if (target(unit.x + neighbor[3][0], unit.y + neighbor[3][1], rangeToDetect, true, true) != null) {
                neighborInRange[3] = true;
            }
            if (target(unit.x + neighbor[4][0], unit.y + neighbor[4][1], rangeToDetect, true, true) != null) {
                neighborInRange[4] = true;
            }
            if (target(unit.x + neighbor[5][0], unit.y + neighbor[5][1], rangeToDetect, true, true) != null) {
                neighborInRange[5] = true;
            }
            if (target(unit.x + neighbor[6][0], unit.y + neighbor[6][1], rangeToDetect, true, true) != null) {
                neighborInRange[6] = true;
            }
            if (target(unit.x + neighbor[7][0], unit.y + neighbor[7][1], rangeToDetect, true, true) != null) {
                neighborInRange[7] = true;
            }
            if (target(unit.x, unit.y, rangeToDetect, true, true) != null) {
                neighborInRange[8] = true;
            }
        }
        if (targetInRange != null && targetInRange != core)
            prevTarget = targetInRange;

        System.out.println("neighbors in Range " + Arrays.toString(neighborInRange));
        System.out.println("neighbors in Range " + Arrays.toString(neighborDist));
>>>>>>> Stashed changes

        Building core = unit.closestEnemyCore();
        Teamc target= target(unit.x, unit.y, unit.type.range, true, true);
        // Teamc target= unit.closestTarget(unit.team, unit.x, unit.y, unit.type.range);
<<<<<<< Updated upstream
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
=======
        System.out.println("core: " + core);
        System.out.println("target " + target);
        Teamc target_core = core;
        if ((target != null && target == target_core && !unit.within(target, unit.type.range * 0.5f))
                && command() == UnitCommand.attack) {
            // if (target != target_core) {
            // // target_core = target;
            // continue;
            // }
            boolean move = false;
            System.out
                    .println("in A: move: " + move + " unit.move " + unit.team + " unit.type.range " + unit.type.range);
            if (move)
                pathfind(Pathfinder.fieldCore);
        } else if((target != null && !unit.within(target, unit.type.range*0.5f)) && command() == UnitCommand.attack){
                boolean move = false;

            // if(state.rules.waves && unit.team == state.rules.defaultTeam){
            //     Tile spawner = getClosestSpawner();
            //     if(spawner != null && unit.within(spawner, state.rules.dropZoneRadius + 120f)) move = false;
            // }
            // System.out.println("move: "+move+" unit.move "+unit.team+" unit.type.range "+unit.type.range);
        }
        else if(friend!=null && friend.type.range < unit.type.range) {
            boolean move = true;
            if(friend != null){
                System.out.println("Moving to frinedly unit");

                moveTo(friend, 1f);
            }
>>>>>>> Stashed changes
        }
        else if(core != null && unit.within(core, unit.range() / 1.3f + core.block.size * tilesize / 2f)){
            target = core;
            for(var mount : unit.mounts){
                if(mount.weapon.controllable && mount.weapon.bullet.collidesGround){
                    mount.target = core;
                }
            }
        }
        
<<<<<<< Updated upstream
        

=======
>>>>>>> Stashed changes
        else if((core == null || !unit.within(core, unit.type.range*0.5f)) && command() == UnitCommand.attack){
            boolean move = true;

            if(state.rules.waves && unit.team == state.rules.defaultTeam){
                Tile spawner = getClosestSpawner();
                if(spawner != null && unit.within(spawner, state.rules.dropZoneRadius + 120f)) move = false;
            }
<<<<<<< Updated upstream
            System.out.println("move: "+move+" unit.move "+unit.team+" unit.type.range "+unit.type.range);
=======
            // System.out.println("move: "+move+" unit.move "+unit.team+" unit.type.range "+unit.type.range);
>>>>>>> Stashed changes
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