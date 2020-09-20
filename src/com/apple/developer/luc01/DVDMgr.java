package com.apple.developer.luc01;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DVDMgr {

    public void initial(DVDSet[] set) {
        set[0].setName("罗马假日");
        set[0].setState("已借出");
        set[0].setDate("2010-7-1");
        set[0].countAdd();

        set[1].setName("风声鹤唳");
        set[1].setState("可出借");

        set[2].setName("浪漫满屋");
        set[2].setState("可出借");

    }

    public void printDVD(DVDSet[] set) {
        System.out.println("--->查看DVD\n");
        System.out.println("序号\t\t\t状态\t\t\t\t名称\t\t\t\t借出日期");

        for (int i = 0; set[i].getName() != null; i++) {
            System.out.println((i + 1) + "\t\t\t" + set[i].getState() + "\t\t\t" + set[i].getName() + "\t\t\t" + set[i].getDate());
        }
        returnMain();
    }

    public void addDVD(DVDSet[] set)
    {
        Scanner input=new Scanner(System.in);

        System.out.println("--->新增DVD\n");
        int index=0;
        for (int i = 0; set[i].getName() != null; i++)
        {
            index++;
        }

        System.out.print("请输入要新增的DVD的名字：");
        String name = input.next();
        set[index].setName(name);

        System.out.println("序号\t\t\t状态\t\t\t\t名称\t\t\t\t借出日期");

        for (int i = 0; set[i].getName() != null; i++) {
            System.out.println((i + 1) + "\t\t\t" + set[i].getState() + "\t\t\t" + set[i].getName() + "\t\t\t" + set[i].getDate());
        }
        returnMain();

    }

    public void deleteDVD(DVDSet[] set)
    {
        System.out.println("__________________");
        System.out.println("--->删除DVD\n");
        Scanner input=new Scanner(System.in);

        System.out.println("序号\t\t\t状态\t\t\t\t名称\t\t\t\t借出日期");

        int end=0;
        for (int i = 0; set[i].getName() != null; i++) {
            System.out.println((i + 1) + "\t\t\t" + set[i].getState() + "\t\t\t" + set[i].getName() + "\t\t\t" + set[i].getDate());
            end++;
        }
        end--;

        System.out.print("请输入要删除的DVD序号：");
        int index=input.nextInt()-1;

        if(set[index].getState().equals("已借出")==true)
            System.out.println(set[index].getName()+"为借出状态，不可删除！");
        else
        {
            for(int i=index;i<end;i++)
            {
                set[i].setName(set[i+1].getName());
                set[i].setState(set[i+1].getState());
                set[i].setDate(set[i+1].getDate());
                set[i].setCounts(set[i+1].getCounts());
            }

            set[end].setName(null);
            set[end].setDate(" ");
            set[end].setState("可出借");
            set[end].resetCounts();
            System.out.println("序号\t\t\t状态\t\t\t\t名称\t\t\t\t借出日期");

            for (int i = 0; set[i].getName() != null; i++) {
                System.out.println((i + 1) + "\t\t\t" + set[i].getState() + "\t\t\t" + set[i].getName() + "\t\t\t" + set[i].getDate());
            }
        }
        returnMain();
    }

    public void lendDVD(DVDSet[] set)
    {
        System.out.println("__________________");
        System.out.println("--->借出DVD\n");
        Scanner input=new Scanner(System.in);

        System.out.println("序号\t\t\t状态\t\t\t\t名称\t\t\t\t借出日期");

        for (int i = 0; set[i].getName() != null; i++) {
            System.out.println((i + 1) + "\t\t\t" + set[i].getState() + "\t\t\t" + set[i].getName() + "\t\t\t" + set[i].getDate());
        }

        System.out.print("请输入你要借出的DVD序号：");
        int index=input.nextInt()-1;

        if(set[index].getState().equals("已借出")==true)
            System.out.println("这本书已借出去尚未归还，请换一本借！");
        else
        {
            System.out.print("请输入借出日期（年-月-日）：");
            String dateLend=input.next();

            set[index].setDate(dateLend);
            set[index].setState("已借出");
            set[index].countAdd();

            System.out.println("您已成功借出"+set[index].getName());
        }
        returnMain();
    }

    public void returnDVD(DVDSet[] set) throws ParseException {
        System.out.println("__________________");
        System.out.println("--->归还DVD\n");
        Scanner input=new Scanner(System.in);

        System.out.print("请输入你要归还的DVD的名字：");
        String name=input.next();

        int index=0;
        for(int i=0;set[i].getName().equals(name)==false;i++)
        {
            index++;
        }

        System.out.print("请输入归还日期（年-月-日）：");

        String dateReturn=input.next();
        String dateLend=set[index].getDate();

        set[index].setState("可出借");
        set[index].setDate(" ");

        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        Date dr=sd.parse(dateReturn);
        Date dl=sd.parse(dateLend);
        double charge = (dr.getTime() - dl.getTime()) / (24 * 60 * 60 * 1000)*0.5;

        System.out.println("您已成功归还：\t《"+set[index].getName()+"》");
        System.out.println("借出日期为："+dateLend);
        System.out.println("归还日期为："+dateReturn);
        System.out.println("应付租金（元）："+charge);
        System.out.println("_____________________________");
        returnMain();
    }

    public String startMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n欢迎来到迷你DVD管理器");
        System.out.println("__________________");
        System.out.println("0、DVD排行榜");
        System.out.println("1、新增DVD");
        System.out.println("2、查看DVD");
        System.out.println("3、删除DVD");
        System.out.println("4、借出DVD");
        System.out.println("5、归还DVD");
        System.out.println("6、退出");
        System.out.println("__________________");

        boolean outer = false;
        do {
            System.out.print("请选择：");
            int choice1 = input.nextInt();
            System.out.println();
            switch (choice1) {
                case 0:
                    outer=false;
                    return "sortDVD";
                case 1:
                    //addDVD();
                    outer = false;
                    return "addDVD";
                case 2:
                    //printDVD();
                    outer = false;
                    return "printDVD";
                case 3:
                    //deleteDVD();
                    outer = false;
                    return "deleteDVD";
                case 4:
                    //lendDVD();
                    outer = false;
                    return "lendDVD";
                case 5:
                    //returnDVD();
                    outer = false;
                    return "returnDVD";
                case 6:
                    System.exit(0);
                default:
                    outer = true;
                    break;
            }
        } while (outer == true);
        return null;
    }

    private void returnMain()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("输入0返回:");
        int in=input.nextInt();
        System.out.println();
        System.out.println("__________________");
        System.out.println();
    }

    public void sortDVD(DVDSet[] set) {
        int index = 0;
        for (int i = 0; set[i + 1].getName() != null; i++)
            index++;
        for (int i = 0; i < index - 1; i++)
            for (int j = 0; j < index - 1 - i; j++) {
                if(set[j].getCounts()<set[j+1].getCounts())
                {
                    String name;
                    String state;
                    String date;
                    int counts;

                    name = set[j].getName();
                    state = set[j].getState();
                    date = set[j].getDate();
                    counts = set[j].getCounts();

                    set[j].setName(set[j + 1].getName());
                    set[j].setState(set[j + 1].getState());
                    set[j].setDate(set[j + 1].getDate());
                    set[j].setCounts(set[j + 1].getCounts());

                    set[j + 1].setName(name);
                    set[j + 1].setState(state);
                    set[j + 1].setDate(date);
                    set[j + 1].setCounts(counts);
                }

            }

        System.out.println("__________________");
        System.out.println("--->DVD排行榜\n");
        System.out.println("次数\t\t\t名称");

        for (int i = 0; set[i].getName() != null; i++) {
            System.out.println(set[i].getCounts() + "\t\t\t" + set[i].getName());
        }
        returnMain();

    }
             
            
}


