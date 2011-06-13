package com.hascode.tutorial.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LdapQuery {
	public static void main(String[] args) throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://127.0.0.1:10389/");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
		env.put(Context.SECURITY_CREDENTIALS, "secret");
		DirContext ctx = new InitialDirContext(env);

		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		NamingEnumeration<SearchResult> enumeration = ctx.search("ou=Users,dc=example,dc=com", "(objectClass=person)", searchControls);
		while (enumeration.hasMore()) {
			SearchResult result = enumeration.next();
			Attributes attrs = result.getAttributes();
			System.out.println(String.format("User found.. %s, %s", attrs.get("cn"), attrs.get("uid")));
		}
	}
}
