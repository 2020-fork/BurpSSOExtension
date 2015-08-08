/**
 * EsPReSSO - Extension for Processing and Recognition of Single Sign-On Protocols.
 * Copyright (C) 2015/ Tim Guenther and Christian Mainka
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package de.rub.nds.burp.utilities.table;

import burp.IBurpExtenderCallbacks;
import burp.IExtensionHelpers;
import burp.IHttpRequestResponsePersisted;
import java.time.LocalTime;

/**
 * A table entry for the class Table.
 * @author Tim Guenther
 * @version 1.0
 */
public class TableEntry {
    private String counter = "";
    private String number = "";
    private String protocol = "";
    private String host = "";
    private String method = "";
    private String url = "";
    private String token = "";
    private String time = "";
    private String length = "";
    private String comment = "";
    private IHttpRequestResponsePersisted fullMessage = null;

    /**
     * Construct a new table entry.
     * @param counter The number of the entry position in the history. 
     * @param number The number of the entry position in the protocol.
     * @param protocol The single sign-on protocol.
     * @param token The token or unique id for the protocol flow.
     * @param requestResponse The content of the request/response.
     * @param callbacks Helper provided by the Burp Suite api.
     */
    public TableEntry(String counter, String number, String protocol, String token, IHttpRequestResponsePersisted requestResponse, IBurpExtenderCallbacks callbacks) {
        IExtensionHelpers helpers = callbacks.getHelpers();
        
        this.counter = counter;
        this.number = number;
        this.protocol = protocol;
        this.host = helpers.analyzeRequest(requestResponse).getUrl().getHost();
        this.method = helpers.analyzeRequest(requestResponse).getMethod();
        this.url = helpers.analyzeRequest(requestResponse).getUrl().getPath();
        this.token = token;
        LocalTime t = LocalTime.now();
        this.time = t.toString();
        this.length = (new Integer(requestResponse.getResponse().length)).toString();
        this.comment = requestResponse.getComment();
        this.fullMessage = requestResponse;
    }

    //Getter
    public String getCounter() {
        return counter;
    }

    public String getNumber() {
        return number;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public String getMethod() {
        return method;
    }
    
    public String getUrl() {
        return url;
    }

    public String getLength() {
        return length;
    }

    public String getToken() {
        return token;
    }

    public String getTime() {
        return time;
    }
    
    public String getComment() {
        return comment;
    }

    public IHttpRequestResponsePersisted getFullMessage() {
        return fullMessage;
    }
    
    

    //Setter
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
    
    
}