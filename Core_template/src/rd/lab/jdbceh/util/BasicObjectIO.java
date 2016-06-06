package rd.lab.jdbceh.util;

/**
 *
 * @author Raslan Rauff
 */
public class BasicObjectIO {
    private Object ioObject;

    public Object getIoObject() {
        return ioObject;
    }

    public void setIoObject(Object ioObject) {
        this.ioObject = ioObject;
    }

    public BasicObjectIO(Object ioObject) {
        this.ioObject = ioObject;
    }
}
    