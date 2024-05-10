public class Zombie extends Entity {
        private TypeZombie typeZombie;


        public TypeZombie getTypeZombie() {
                return typeZombie;
        }

        public void setTypeZombie(TypeZombie typeZombie) {
                this.typeZombie = typeZombie;
        }


        // Construktor
        public Zombie(int hp, int level, TypeZombie typeZombie) {
                super(hp, level);
                this.typeZombie = typeZombie;
        }


        // Metode Menampilkan Informasi Zombie
        public void entityInfo () {
                System.out.println("# ZOMBIE DENGAN TIPE : " + typeZombie + ", DAN Level: " + getLevel());
        }


        // Metode Menyerang Player
        public void attack (Player player) {
                if (getHp() > 0) {
                        if (player.getHp() > 0) {
                                System.out.println("player : ughhh");
                                if(typeZombie == TypeZombie.MELEE) {
                                        player.decreaseHpMelee();
                                        if(player.getHp() <= 0) {
                                                System.out.println("# YOU DIE GAME OVER");
                                        }
                                } else if (typeZombie == TypeZombie.RANGED) {
                                        player.decreaseHpRanged();
                                        if(player.getHp() <= 0) {
                                                System.out.println("# YOU DIE GAME OVER");
                                        }
                                }
                        }else {
                                System.out.println("# PLAYER SUDAH MATI");
                        }
                }
                else {System.out.println("# ZOMBIE SUDAH MATI");}

        }
}


// Enum
enum TypeZombie {
        MELEE,
        RANGED
}
