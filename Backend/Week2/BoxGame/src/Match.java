import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight){
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;

    }

    void run(){
        if (isCheck()){
            while(this.f1.health > 0 && this.f2.health > 0){
                System.out.println("***** YENI RAUND *****");
                if (Math.random()<0.5) {
                    this.f2.health = this.f1.hit(this.f2);
                    this.f1.health = this.f2.hit(this.f1);
                }
                else{
                    this.f1.health = this.f2.hit(this.f1);
                    this.f2.health = this.f1.hit(this.f2);
                }
                if (isWin()){
                    break;
                }

                if (isWin()){
                    break;
                }
                System.out.println(this.f1.name + " sagligi " + this.f1.health);
                System.out.println(this.f2.name + " sagligi " + this.f2.health);
            }

        }else{
            System.out.println("Sikletler uyusmuyor!");
        }
    }

    boolean isCheck(){
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin(){
        if (this.f1.health == 0){
            System.out.println(this.f2.name + " kazandi!");
            return true;
        }
        if (this.f2.health == 0 ){
            System.out.println(this.f1.name + " kazandi!");
            return true;
        }
        return false;
    }
}
