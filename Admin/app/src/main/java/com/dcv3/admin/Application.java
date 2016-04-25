package com.dcv3.admin;

import com.parse.Parse;

/**
 * Created by dezereljones on 4/25/16.
 */
public class Application extends android.app.Application{
    @Override
    public void onCreate(){
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "Gokvsi0NGFg7I87lMaRgLjz6XILpfR1AofzzxKOF", "cmVUZO1VJRrGSRBbc3LmdYluCjxisZKv5nEIx1fl");
    }
}
