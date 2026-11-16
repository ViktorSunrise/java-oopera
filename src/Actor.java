public class Actor extends Person {
    private double height;

    public Actor(String name, String surname, Gender gender, double height) {
        super(name, surname, gender);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " (" + height + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {                      // один и тот же объект
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // другой тип или null
            return false;
        }
        Actor actor = (Actor) obj;
        return Double.compare(actor.height, height) == 0
                && getName().equals(actor.getName())
                && getSurname().equals(actor.getSurname());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getName(), getSurname(), height);
    }
}