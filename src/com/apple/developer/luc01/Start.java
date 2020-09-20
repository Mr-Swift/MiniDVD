package com.apple.developer.luc01;

import java.text.ParseException;

public class Start {
    public static void main(String[] args) throws ParseException {

            DVDMgr mgr = new DVDMgr();
            DVDSet[] set = new DVDSet[100];

            for (int i = 0; i < set.length; i++)
                set[i] = new DVDSet(null, "可出借", " ", 0);

            mgr.initial(set);


            while(true)
            {
                String choice1=mgr.startMenu();

                switch(choice1)
                {
                    case "sortDVD":
                        mgr.sortDVD(set);
                        break;

                    case "addDVD":
                        mgr.addDVD(set);
                        break;

                    case "printDVD":
                        mgr.printDVD(set);
                        break;

                    case "deleteDVD":
                        mgr.deleteDVD(set);
                        break;

                    case "lendDVD":
                        mgr.lendDVD(set);
                        break;

                    case "returnDVD":
                        mgr.returnDVD(set);
                        break;
                }
            }
    }
}
