package org.tempuri;

public class PostOfficeSoapProxy implements org.tempuri.PostOfficeSoap {
  private String _endpoint = null;
  private org.tempuri.PostOfficeSoap postOfficeSoap = null;
  
  public PostOfficeSoapProxy() {
    _initPostOfficeSoapProxy();
  }
  
  public PostOfficeSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initPostOfficeSoapProxy();
  }
  
  private void _initPostOfficeSoapProxy() {
    try {
      postOfficeSoap = (new org.tempuri.PostOfficeLocator()).getPostOfficeSoap();
      if (postOfficeSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)postOfficeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)postOfficeSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (postOfficeSoap != null)
      ((javax.xml.rpc.Stub)postOfficeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.PostOfficeSoap getPostOfficeSoap() {
    if (postOfficeSoap == null)
      _initPostOfficeSoapProxy();
    return postOfficeSoap;
  }
  
  public java.lang.String hello() throws java.rmi.RemoteException{
    if (postOfficeSoap == null)
      _initPostOfficeSoapProxy();
    return postOfficeSoap.hello();
  }
  
  
}