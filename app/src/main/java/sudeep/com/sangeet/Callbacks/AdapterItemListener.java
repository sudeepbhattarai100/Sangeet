package sudeep.com.sangeet.Callbacks;

import sudeep.com.sangeet.POJO.Music;


public interface AdapterItemListener {

    public void itemTouch(int  index);

    public void download(int index);

    public void firebaseAuthentication();

    public void firebaseSignOut();

}
