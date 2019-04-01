public class JBtor {
    public JBtor() {
        jbtorC();
    }

    native void jbtorC();

    public void jbtorRelease() {
        jbtorReleaseC();
    }

    private native void jbtorReleaseC();
}
