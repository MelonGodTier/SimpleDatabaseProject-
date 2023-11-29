package next.xadmin.login.web;

import java.util.HashSet;

public class SessionHashSet {
static HashSet<String> sessionStorage = null;

public static HashSet getsessionStorage(){
	if(sessionStorage == null) {
	   sessionStorage = new HashSet<String>();
	} 
	return sessionStorage;
}
}
