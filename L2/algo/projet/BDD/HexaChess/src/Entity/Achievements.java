package src.Entity;

public class Achievements {
    private String achievementId;
    private String name;
    private String description;

    public Achievements(String achievementId, String name, String description) {
        this.achievementId = achievementId;
        this.name = name;
        this.description = description;
    }

    
    public String getAchievementId() { return achievementId; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
}