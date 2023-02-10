package rs.raf.core.util;

import java.util.ArrayList;
import java.util.List;

public class DefinedRoleListFactory {
    public static List<String> generateDefinedRoles(boolean admin, boolean client, boolean manager){
        List<String> definedRoles = new ArrayList<>();
        if(admin && !client && !manager){
            definedRoles.add("0");
        }
        if(!admin && client && !manager){
            definedRoles.add("1");
        }
        if(!admin && !client && manager){
            definedRoles.add("2");
        }
        if(admin && client && !manager){
            definedRoles.add("0");
            definedRoles.add("1");
        }
        if(admin && !client && manager){
            definedRoles.add("0");
            definedRoles.add("2");
        }
        if(!admin && client && manager){
            definedRoles.add("1");
            definedRoles.add("2");
        }
        if(admin && client && manager){
            definedRoles.add("0");
            definedRoles.add("1");
            definedRoles.add("2");
        }
        return definedRoles;
    }
}
