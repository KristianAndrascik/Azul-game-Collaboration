package sk.uniba.fmph.dcs;

enum FinishRoundResult {
    NORMAL,
    GAME_FINISHED;

    @Override
    public String toString() {
        switch(this) {
            case NORMAL :
                return "normal";
            case GAME_FINISHED:
                return "game_finished";
            default:
                return null;
        }
    }
}