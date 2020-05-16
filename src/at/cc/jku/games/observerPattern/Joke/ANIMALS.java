package at.cc.jku.games.observerPattern.Joke;

public enum ANIMALS {
     DOG {//, DUCK, CAT, COW;

         @Override
         public String toString() {
             return "dog";
         }
     },

    DUCK {
        @Override
        public String toString() {
            return "duck";
        }
    },

    CAT{
        @Override
        public String toString() {
            return "cat";
        }
    },

    COW {
        @Override
        public String toString() {
            return "cow";
        }
    }


}
