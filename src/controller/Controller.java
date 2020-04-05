package controller;

import character.*;
import weapon.*;

import java.util.Random;

/**
 * @author qanna
 */
public class Controller {

    private Player attacker;
    private Player victim;


    public Wind generateWind(){
        Wind wind = new Wind();
        wind.setWindSpeed(randomDistance(-wind.getWindRange(),wind.getWindRange()+1));
        return wind;
    }

    public String throwWeapon(Weapon wp, Wind wd, Player attacker, Player victim){
        String attackResult = "";
        //补血工具，attacker给自己补血
        if(wp instanceof PowerUp){
            addBlood(wp,attacker);
            attackResult += "攻击者血量回升";
        }
        else{
            //攻击工具，victim受到weapon的攻击
            int power = attacker.getPowerByPlayer();
            wp.setPosition(power);
            attackResult += "发射武器的力度为";
            attackResult += power;
            if(getHurt(wp, wd, victim)){
                attackResult += "，武器击中对方";
            }
            else{
                attackResult += "，武器未击中对方";
            }
        }
        return attackResult;

    }

    public void addBlood(Weapon wp, Player attacker){
        int afterBlood = attacker.getBloodVolume()-wp.getDamage();
        attacker.setBloodVolume(afterBlood > attacker.getAllVolume()?attacker.getAllVolume(): afterBlood);
    }

    public boolean getHurt(Weapon wp, Wind wd, Player victim){
        boolean isHit = true;
        wp.setPosition(wp.getPosition()+ wd.getWindSpeed());
        if(Math.abs(victim.getPlayerPosition() - wp.getPosition()) > wp.getRange()){
            //超出武器攻击范围
            isHit = false;
        }
        else {
            //被击中
            int afterBlood = victim.getBloodVolume() - wp.getDamage();
            victim.setBloodVolume(afterBlood < 0 ? 0: afterBlood);
        }
        return isHit;
    }


    public boolean gameOver(Player player){
        return player.getBloodVolume() <= 0;
    }

    /**
     * 随机生成两个数之间的整数，包含最小值，但不包含最大值
     */
    public static int randomDistance(int min, int max){

        return new Random().nextInt(max- min)+ min;
    }


    public void changeAttacker(){

        Player p = this.getAttacker();
        this.setAttacker(this.getVictim());
        this.setVictim(p);
    }



    public Player getAttacker() {
        return attacker;
    }

    public void setAttacker(Player attacker) {
        this.attacker = attacker;
    }

    public Player getVictim() {
        return victim;
    }

    public void setVictim(Player victim) {
        this.victim = victim;
    }
}
