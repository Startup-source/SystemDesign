package CreationDesigns;

public class BuilderPattern {

    private final String size;
    private final boolean cheese;
    private final boolean mushroom;
    private final boolean paneer;

    private BuilderPattern(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.mushroom = builder.mushroom;
        this.paneer = builder.paneer;
    }


    public static class Builder {
        private final String size;
        private boolean cheese;
        private boolean mushroom;
        private boolean paneer;

        public Builder(String size) {
            this.size = size;
        }

        public Builder cheese(boolean value){
            this.cheese = value;
            return this;
        }

        public Builder mushroom(boolean value) {
            this.mushroom = mushroom;
            return this;
        }

        public Builder paneer(boolean value) {
            this.paneer = value;
            return this;
        }

        public BuilderPattern build() {
            return new BuilderPattern(this);
        }
    }
}
