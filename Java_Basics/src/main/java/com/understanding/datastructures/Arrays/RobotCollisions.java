package Java_Basics.src.main.java.com.understanding.datastructures.Arrays;

import java.util.*;

public class RobotCollisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        char[] directionArray = directions.toCharArray();
        Queue<RobotMovement> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.position, y.position));
        for(int i = 0; i < positions.length; i++){
            RobotMovement robotMovement = new RobotMovement(healths[i], directionArray[i], positions[i], i);
            pq.add(robotMovement);
        }
        Stack<RobotMovement> stack = new Stack<>();
        while(!pq.isEmpty()){
            RobotMovement currentRobot = pq.poll();
            if(stack.isEmpty()){
                stack.push(currentRobot);
            }else{
                boolean toPush = false;
                while(!stack.isEmpty()){
                    RobotMovement previousRobot = stack.peek();
                    if(previousRobot.direction == 'R' && currentRobot.direction == 'L'){
                        if(previousRobot.health > currentRobot.health){
                            previousRobot.health -= 1;
                            toPush = false;
                            break;
                        }else if(previousRobot.health < currentRobot.health){
                            currentRobot.health -= 1;
                            stack.pop();
                            toPush = true;
                        }else{
                            stack.pop();
                            toPush = false;
                            break;
                        }
                    }else{
                        toPush = true;
                        break;
                    }
                }
                if(toPush)
                    stack.push(currentRobot);
            }
        }
        List<Integer> result = new ArrayList<>();
        pq = new PriorityQueue<>((x,y) -> x.index - y.index);
        while(!stack.isEmpty()){
            pq.offer(stack.pop());
        }
        while(!pq.isEmpty()){
            result.add(pq.poll().health);
        }
        return result;
    }

    private class RobotMovement{
        int health;
        char direction;
        int position;
        int index;
        public RobotMovement(int health, char direction, int pos, int index){
            this.health = health;
            this.direction = direction;
            this.position = pos;
            this.index = index;
        }
    }
}
