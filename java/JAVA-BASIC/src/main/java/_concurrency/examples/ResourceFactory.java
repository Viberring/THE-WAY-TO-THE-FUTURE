package _concurrency.examples;

/**
 * ResourceFactory
 * <p/>
 * Lazy initialization holder class idiom
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class ResourceFactory {
    private static class ResourceHolder {
        public static Resource resource = new Resource();
    }

    public static Resource getResource() {
        return ResourceHolder.resource;
    }

    static class Resource {
    }
}
