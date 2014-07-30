package ua.cviewer.dao;

/**
 *
 * @author RomaSHKA
 */
public interface ClientDAO {
    int newClient();
    void setPass(int id, long pass);
    void riseCount(int id, long pass);
    void dountCount(int id, long pass);
    void setBaned(int id);   
    int imageAvailable(int id, long pass);
    int getRate(int id, long pass);
    void riseRate(int id, long pass);
    void downRate(int id, long pass);
    int lastPhotoID(int id, long pass);   
}
