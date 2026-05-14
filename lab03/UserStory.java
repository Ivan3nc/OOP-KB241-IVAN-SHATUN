public class UserStory extends Ticket {
    private UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory[] dependencies) {
        super(id, name, estimate);
        this.dependencies = dependencies;
    }

    @Override
    public void complete() {
        if (dependencies != null) {
            for (UserStory dep : dependencies) {
                if (dep != null && !dep.isCompleted()) {
                    return; 
                }
            }
        }
        super.complete();
    }

    public UserStory[] getDependencies() {
        if (dependencies == null) {
            return new UserStory[0];
        }
        UserStory[] copy = new UserStory[dependencies.length];
        for (int i = 0; i < dependencies.length; i++) {
            copy[i] = dependencies[i];
        }
        return copy;
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
