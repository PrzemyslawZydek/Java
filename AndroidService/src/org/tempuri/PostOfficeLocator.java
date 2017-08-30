/**
 * PostOfficeLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PostOfficeLocator extends org.apache.axis.client.Service implements org.tempuri.PostOffice {

    public PostOfficeLocator() {
    }


    public PostOfficeLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PostOfficeLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PostOfficeSoap
    private java.lang.String PostOfficeSoap_address = "http://zydekp.gear.host/PostOffice.asmx";

    public java.lang.String getPostOfficeSoapAddress() {
        return PostOfficeSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PostOfficeSoapWSDDServiceName = "PostOfficeSoap";

    public java.lang.String getPostOfficeSoapWSDDServiceName() {
        return PostOfficeSoapWSDDServiceName;
    }

    public void setPostOfficeSoapWSDDServiceName(java.lang.String name) {
        PostOfficeSoapWSDDServiceName = name;
    }

    public org.tempuri.PostOfficeSoap getPostOfficeSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PostOfficeSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPostOfficeSoap(endpoint);
    }

    public org.tempuri.PostOfficeSoap getPostOfficeSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.PostOfficeSoapStub _stub = new org.tempuri.PostOfficeSoapStub(portAddress, this);
            _stub.setPortName(getPostOfficeSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPostOfficeSoapEndpointAddress(java.lang.String address) {
        PostOfficeSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.PostOfficeSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.PostOfficeSoapStub _stub = new org.tempuri.PostOfficeSoapStub(new java.net.URL(PostOfficeSoap_address), this);
                _stub.setPortName(getPostOfficeSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PostOfficeSoap".equals(inputPortName)) {
            return getPostOfficeSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "PostOffice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "PostOfficeSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PostOfficeSoap".equals(portName)) {
            setPostOfficeSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
