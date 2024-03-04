public class Main {
    public static void main(String[] args) {
        int[][] list= {{5,8,9},{2,3,7}};
        System.out.println("Matrix : ");

        //First printing matrix's first version
        for (int vertical = 0; vertical < list.length; vertical++) {
            for (int horizon = 0; horizon < list[vertical].length; horizon++) {
                System.out.print(list[vertical][horizon]+" ");
            }
            System.out.println("");
        }

        //Then transposing it
        System.out.println("result : ");

        for (int vertical = 0; vertical <list[0].length ; vertical++) {
            for (int horizon = 0; horizon < list.length ; horizon++) {
                System.out.print(list[horizon][vertical]+" ");
            }
            System.out.println("");
        }
    }
}