package Task2;

public class Panettone {

    private static int panettoneTotalCount = 0;
    private static int chocolatePanettoneCount = 0;
    private static int raisinPanettoneCount = 0;
    private String filling;

    public Panettone(String filling) {
        this.setFilling(filling);
        panettoneTotalCount++;
    }

    public static int getPanettoneTotalCount() {
        return panettoneTotalCount;
    }

    public String getFilling() {
        return filling;
    }

    public static int getChocolatePanettoneCount() {
        return chocolatePanettoneCount;
    }

    public static int getRaisinPanettoneCount() {
        return raisinPanettoneCount;
    }

    public void setFilling(String filling) {
        if ("chocolate".equalsIgnoreCase(filling)) {
            this.filling = filling;
            chocolatePanettoneCount++;
        } else if ("raisin".equalsIgnoreCase(filling)) {
            this.filling = filling;
            raisinPanettoneCount++;
        } else {
            System.out.println("No such filling \"" + filling + "\" exists!");
            panettoneTotalCount--;
        }
    }

    public static void getDetails() {
        System.out.println("\tPanettone for the day" +
                "\nTotal baked panettone: " + panettoneTotalCount +
                "\nTotal baked chocolate panettone: " + chocolatePanettoneCount +
                "\nTotal baked raisin panettone: " + raisinPanettoneCount);
    }
}
