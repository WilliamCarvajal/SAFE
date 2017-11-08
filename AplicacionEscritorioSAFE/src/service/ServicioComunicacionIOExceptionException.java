
/**
 * ServicioComunicacionIOExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.6  Built on : Jul 30, 2017 (09:08:31 BST)
 */

package service;

public class ServicioComunicacionIOExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1510100132034L;
    
    private service.ServicioComunicacionStub.ServicioComunicacionIOException faultMessage;

    
        public ServicioComunicacionIOExceptionException() {
            super("ServicioComunicacionIOExceptionException");
        }

        public ServicioComunicacionIOExceptionException(java.lang.String s) {
           super(s);
        }

        public ServicioComunicacionIOExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ServicioComunicacionIOExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(service.ServicioComunicacionStub.ServicioComunicacionIOException msg){
       faultMessage = msg;
    }
    
    public service.ServicioComunicacionStub.ServicioComunicacionIOException getFaultMessage(){
       return faultMessage;
    }
}
    