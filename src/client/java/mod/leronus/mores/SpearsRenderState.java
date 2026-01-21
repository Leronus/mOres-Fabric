package mod.leronus.mores;

public final class SpearsRenderState {
    private SpearsRenderState() {}

    // true only while DrawContext is resolving the GUI icon model
    private static final ThreadLocal<Boolean> IN_GUI =
            ThreadLocal.withInitial(() -> Boolean.FALSE);

    public static void pushGui(boolean inGui) {
        IN_GUI.set(inGui);
    }

    public static void popGui() {
        IN_GUI.remove();
    }

    public static boolean isInGui() {
        return IN_GUI.get();
    }
}
