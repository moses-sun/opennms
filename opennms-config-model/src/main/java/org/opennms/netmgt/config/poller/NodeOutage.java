/*
 * This class was converted to JAXB from Castor.
 */

package org.opennms.netmgt.config.poller;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.Validator;
import org.xml.sax.ContentHandler;

/**
 * Configuration of node-outage
 *  functionality
 */

@XmlRootElement(name="node-outage")
@XmlAccessorType(XmlAccessType.FIELD)
public class NodeOutage implements Serializable {
    private static final long serialVersionUID = 2987086736880060911L;

    /**
     * Enable/disable node outage processing
     */
    @XmlAttribute(name="status")
    private String m_status;

    /**
     * Defines behavior of node outage processing when a
     *  service has changed status to DOWN and a critical service
     * is not
     *  defined. If "true", all remaining services on the interface
     * are
     *  polled.
     */
    @XmlAttribute(name="pollAllIfNoCriticalServiceDefined")
    private String m_pollAllIfNoCriticalServiceDefined = "true";

    /**
     * Critical service. Defining a critical service greatly
     *  reduces the traffic generated by the poller when an
     * interface is DOWN.
     *  When an interface is DOWN only the critical service is
     * polled. If and
     *  when the critical service comes back UP then the
     * interface's other
     *  services are polled to determine their status. When an
     * interface is UP
     *  all services are polled as expected. If the critical
     * service goes DOWN,
     *  all services are considered to be DOWN and therefore the
     * interface is
     *  also considered DOWN.
     */
    @XmlElement(name="critical-service")
    private CriticalService m_criticalService;


    //----------------/
    //- Constructors -/
    //----------------/

    public NodeOutage() {
        super();
    }


    //-----------/
    //- Methods -/
    //-----------/

    /**
     * Overrides the Object.equals method.
     * 
     * @param obj
     * @return true if the objects are equal.
     */
    @Override()
    public boolean equals(final Object obj) {
        if ( this == obj ) return true;

        if (obj instanceof NodeOutage) {
            final NodeOutage temp = (NodeOutage)obj;
            if (m_status != null) {
                if (temp.m_status == null) {
                    return false;
                } else if (!(m_status.equals(temp.m_status))) {
                    return false;
                }
            } else if (temp.m_status != null) {
                return false;
            }
            if (m_pollAllIfNoCriticalServiceDefined != null) {
                if (temp.m_pollAllIfNoCriticalServiceDefined == null) {
                    return false;
                } else if (!(m_pollAllIfNoCriticalServiceDefined.equals(temp.m_pollAllIfNoCriticalServiceDefined))) {
                    return false;
                }
            } else if (temp.m_pollAllIfNoCriticalServiceDefined != null) {
                return false;
            }
            if (m_criticalService != null) {
                if (temp.m_criticalService == null) {
                    return false;
                } else if (!(m_criticalService.equals(temp.m_criticalService))) {
                    return false;
                }
            } else if (temp.m_criticalService != null) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Returns the value of field 'criticalService'. The field
     * 'criticalService' has the following description: Critical
     * service. Defining a critical service greatly
     *  reduces the traffic generated by the poller when an
     * interface is DOWN.
     *  When an interface is DOWN only the critical service is
     * polled. If and
     *  when the critical service comes back UP then the
     * interface's other
     *  services are polled to determine their status. When an
     * interface is UP
     *  all services are polled as expected. If the critical
     * service goes DOWN,
     *  all services are considered to be DOWN and therefore the
     * interface is
     *  also considered DOWN.
     * 
     * @return the value of field 'CriticalService'.
     */
    public CriticalService getCriticalService() {
        return m_criticalService;
    }

    /**
     * Returns the value of field
     * 'pollAllIfNoCriticalServiceDefined'. The field
     * 'pollAllIfNoCriticalServiceDefined' has the following
     * description: Defines behavior of node outage processing when
     * a
     *  service has changed status to DOWN and a critical service
     * is not
     *  defined. If "true", all remaining services on the interface
     * are
     *  polled.
     * 
     * @return the value of field
     * 'PollAllIfNoCriticalServiceDefined'.
     */
    public String getPollAllIfNoCriticalServiceDefined() {
        return m_pollAllIfNoCriticalServiceDefined == null? "true" : m_pollAllIfNoCriticalServiceDefined;
    }

    /**
     * Returns the value of field 'status'. The field 'status' has
     * the following description: Enable/disable node outage
     * processing
     * 
     * @return the value of field 'Status'.
     */
    public String getStatus() {
        return m_status;
    }

    /**
     * Overrides the Object.hashCode method.
     * <p>
     * The following steps came from <b>Effective Java Programming
     * Language Guide</b> by Joshua Bloch, Chapter 3
     * 
     * @return a hash code value for the object.
     */
    public int hashCode() {
        int result = 17;

        if (m_status != null) {
            result = 37 * result + m_status.hashCode();
        }
        if (m_pollAllIfNoCriticalServiceDefined != null) {
            result = 37 * result + m_pollAllIfNoCriticalServiceDefined.hashCode();
        }
        if (m_criticalService != null) {
            result = 37 * result + m_criticalService.hashCode();
        }

        return result;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid() {
        try {
            validate();
        } catch (final ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(final Writer out) throws MarshalException, ValidationException {
        Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws IOException if an IOException occurs during
     * marshaling
     * @throws ValidationException if this
     * object is an invalid instance according to the schema
     * @throws MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(final ContentHandler handler) throws IOException, MarshalException, ValidationException {
        Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'criticalService'. The field
     * 'criticalService' has the following description: Critical
     * service. Defining a critical service greatly
     *  reduces the traffic generated by the poller when an
     * interface is DOWN.
     *  When an interface is DOWN only the critical service is
     * polled. If and
     *  when the critical service comes back UP then the
     * interface's other
     *  services are polled to determine their status. When an
     * interface is UP
     *  all services are polled as expected. If the critical
     * service goes DOWN,
     *  all services are considered to be DOWN and therefore the
     * interface is
     *  also considered DOWN.
     * 
     * @param criticalService the value of field 'criticalService'.
     */
    public void setCriticalService(final CriticalService criticalService) {
        m_criticalService = criticalService;
    }

    /**
     * Sets the value of field 'pollAllIfNoCriticalServiceDefined'.
     * The field 'pollAllIfNoCriticalServiceDefined' has the
     * following description: Defines behavior of node outage
     * processing when a
     *  service has changed status to DOWN and a critical service
     * is not
     *  defined. If "true", all remaining services on the interface
     * are
     *  polled.
     * 
     * @param pollAllIfNoCriticalServiceDefined the value of field
     * 'pollAllIfNoCriticalServiceDefined'.
     */
    public void setPollAllIfNoCriticalServiceDefined(final String pollAllIfNoCriticalServiceDefined) {
        m_pollAllIfNoCriticalServiceDefined = pollAllIfNoCriticalServiceDefined;
    }

    /**
     * Sets the value of field 'status'. The field 'status' has the
     * following description: Enable/disable node outage processing
     * 
     * @param status the value of field 'status'.
     */
    public void setStatus(final String status) {
        m_status = status;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * NodeOutage
     */
    public static NodeOutage unmarshal(final Reader reader) throws MarshalException, ValidationException {
        return (NodeOutage) Unmarshaller.unmarshal(NodeOutage.class, reader);
    }

    /**
     * 
     * 
     * @throws ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate() throws ValidationException {
        new Validator().validate(this);
    }


    @Override
    public String toString() {
        return "NodeOutage[status=" + m_status + ",pollAllIfNoCriticalServiceDefined=" + m_pollAllIfNoCriticalServiceDefined + ",criticalService=" + m_criticalService + "]";
    }

}
