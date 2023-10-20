public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    double firstHit;

    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeight, double firstHit) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.firstHit = firstHit;
    }

    public double firstHit() {
        double randomNumber = Math.random() * 100;
        return this.firstHit = randomNumber;
    }

    public void run() {
        if(isCheck()) {
            int round = 1;
            if(firstHit > 50) {
                System.out.println("===Round 1====");
                System.out.println("Yeni raunda " + f1.name + " başlıyor.");
                this.f2.health = this.f1.hit(this.f2);
                this.f1.health = this.f2.hit(this.f1);
                System.out.println(this.f1.name + " Sağlık: " + this.f1.health);
                System.out.println(this.f2.name + " Sağlık: " + this.f2.health);
            } else {
                System.out.println("====Round 1====");
                System.out.println("Yeni raunda " + f2.name + " başlıyor.");
                this.f1.health = this.f2.hit(this.f1);
                this.f1.health = this.f2.hit(this.f1);

                System.out.println(this.f1.name + " Sağlık: " + this.f1.health);
                System.out.println(this.f2.name + " Sağlık: " + this.f2.health);
            }
            while(this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("===Round " + round + "===");
                this.f2.health = this.f1.hit(this.f2);
                if(isWin())
                    break;
                this.f1.health = this.f2.hit(this.f1);
                if(isWin())
                    break;
                System.out.println(this.f1.name + " Sağlık: " + this.f1.health);
                System.out.println(this.f2.name + " Sağlık: " + this.f2.health);
            }
        } else {
            System.out.println("Sporcuların sikletleri uymuyor.");
        }
    }

    public boolean isCheck() {
            return (this.f1.weight >= this.minWeight && this.f1.weight <= this.maxWeight) && (this.f2.weight >= this.minWeight && this.f2.weight <= this.maxWeight);
        }

    public boolean isWin() {
        if(this.f1.health == 0) {
            System.out.println(f2.name + " kazandı!");
            return true;
        }

        if(this.f2.health == 0) {
            System.out.println(f1.name + " kazandı.");
            return true;
        }

        return false;
    }
}

