
/**
 * ExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package mypackage;

public class ExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1493082551763L;
    
    private mypackage.MelbourneWeather2Stub.ExceptionE faultMessage;

    
        public ExceptionException() {
            super("ExceptionException");
        }

        public ExceptionException(java.lang.String s) {
           super(s);
        }

        public ExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(mypackage.MelbourneWeather2Stub.ExceptionE msg){
       faultMessage = msg;
    }
    
    public mypackage.MelbourneWeather2Stub.ExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    