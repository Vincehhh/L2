package src.Entity;

public class Settings {
    private String playerId;
    private String theme;
    private boolean showLegalMoves;
    private boolean autoPromoteQueen;
    private int aiDifficultyLevel;

    public Settings(String playerId, String theme, boolean showLegalMoves, 
                   boolean autoPromoteQueen, int aiDifficultyLevel) {
        this.playerId = playerId;
        this.theme = theme;
        this.showLegalMoves = showLegalMoves;
        this.autoPromoteQueen = autoPromoteQueen;
        this.aiDifficultyLevel = aiDifficultyLevel;
    }

    public Settings(String playerId) {
        this(playerId, "default", true, false, 1);
    }

    public String getPlayerId() { return playerId; }
    public String getTheme() { return theme; }
    public boolean isShowLegalMoves() { return showLegalMoves; }
    public boolean isAutoPromoteQueen() { return autoPromoteQueen; }
    public int getAiDifficultyLevel() { return aiDifficultyLevel; }

    public void setTheme(String theme) { this.theme = theme; }
    public void setShowLegalMoves(boolean showLegalMoves) { this.showLegalMoves = showLegalMoves; }
    public void setAutoPromoteQueen(boolean autoPromoteQueen) { this.autoPromoteQueen = autoPromoteQueen; }
    public void setAiDifficultyLevel(int aiDifficultyLevel) { this.aiDifficultyLevel = aiDifficultyLevel; }
}
