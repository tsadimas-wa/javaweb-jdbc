/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.uniwa.ice.hrproject.util;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionIdListener;
import jakarta.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener, HttpSessionAttributeListener {

    private SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");

    private String date() {
        return this.formatter.format(new Date());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(this.date() + ": Attribute Added to Session " + event.getSession().getId()
                + " -> Name: " + event.getName() + ", Value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println(this.date() + ": Attribute Removed from Session " + event.getSession().getId()
                + " -> Name: " + event.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println(this.date() + ": Attribute Replaced in Session " + event.getSession().getId()
                + " -> Name: " + event.getName() + ", New Value: " + event.getSession().getAttribute(event.getName()));
    }

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println(this.date() + ": Session " + e.getSession().getId() + " created.");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        System.out.println(this.date() + ": Session " + e.getSession().getId() + " destroyed.");

    }

    @Override
    public void sessionIdChanged(HttpSessionEvent e, String oldSessionId) {
        System.out.println(this.date() + ": Session ID " + oldSessionId + " changed to " + e.getSession().getId());

    }

}
