package interact;

import controller.Controller;

import java.util.Scanner;

/**
 * @author qanna
 */
public class NewGame {
    public Controller controller;
    public Game game;
    private int mode;
    public static int flag;

    public void start(){

        int count =0;

        /*mode只能为0或1*/
        this.setMode(getChooseMode());
        /* 通过用户的输入选择mode来获取游戏模式*/
        this.game = getGamebyMode();

        System.out.println("。。。。。。。。。。游戏开始。。。。。。。。。。");
        this.controller = this.game.getController();
        while(!this.controller.gameOver(this.controller.getAttacker())){
            System.out.println(this.controller.getAttacker().getName()+"的血量:"+this.controller.getAttacker().getBloodVolume());
            System.out.println(this.controller.getVictim().getName()+"的血量:"+this.controller.getVictim().getBloodVolume()+"\n");
            System.out.println("===================第" + (++count) + "轮攻击开始==================");
            System.out.println("【现在轮到"+this.controller.getAttacker().getName()+"攻击】");
            if(!this.game.round()){
                System.out.println("游戏出现故障，请稍后重启");
                break;
            }
            this.controller.changeAttacker();

        }
        System.out.println("游戏结束");
        System.out.println("胜："+this.controller.getVictim().getName() + "\t当前血量为" +  this.controller.getVictim().getBloodVolume());
        System.out.println("负："+this.controller.getAttacker().getName() + "\t当前血量为" + this.controller.getAttacker().getBloodVolume() );


    }

    public Game getGamebyMode() {

        Game gm;
        if (this.mode == Game.ONE){
            System.out.println("现在是单人模式");
            gm = new OnePlayer();
        }
        else {
            System.out.println("现在是双人模式");
            gm = new TwoPlayer();
        }
        return gm;
    }

    /**
     * 选择游戏模式
     */

    public int getChooseMode(){
        System.out.println("请选择模式   0：单人模式  1：双人模式");
        int choose=getUserInput();
        choose=verChooseMode(choose);
        return choose;

    }
    public int verChooseMode(int choose){
        int verifiedPower = choose;
        while (verifiedPower !=0 && verifiedPower != 1){
            System.out.println("请正确输入：");
            verifiedPower = getUserInput();
        }
        return verifiedPower;

    }
    public int getUserInput(){
        int num = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            num = scanner.nextInt();
        }
        catch (Exception e){
            num = Game.INPUT_ERROR;
        }
        return num;
    }



    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }


}
