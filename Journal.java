
/*
 * This is the Journal class. This will be a singleton class, ie there is only
 * one, so if you try to create new objects you only get the same one back.
 * This class is responsible for interfacing with the database and returning
 * Entry objects for our application to manipulate. There will be 5 core
 * operations that will be described bellow: add, delete, update, list and
 * search. Currently the structure allows for searching the title of the 
 * entries. For other filter functionality more methods will need to be 
 * supplied, but for now this should be decent groundwork.
 */
public class Journal {
  
  /*
   * Name: Journal
   * Purpose: This method is the primare constructor, the method signature
   * will be slightly differnet when implement as a singleton, but the idea
   * is the same. The constructor takes no arguments but checks to see if
   * an instance of itself exists, if so it returns that, otherwise it 
   * creates one. This will also possibly create a database if there is none.
   * Parameters: none
   */
  public Journal();

  /*
   * Name: add
   * Purpose: This adds an entry to the database. It gets sent an object
   * that it will attempt to add to the database. If the key, located inside
   * the object is already in the database then it should return false.
   * true should be returned if the entry is successfully added.
   * Parameters: Entry e to be added
   * Return: Boolean value representing succes of adding to db
   */
  public Boolean add(Entry e);

  /*
   * Name: delete
   * Purpose: This method deletes an entry, it uses the key that is part
   * of every Entry object to idendify the object in the database and then
   * removes it. Returns true if delete and false if entry is not found
   * Parameters: Entry e to be deleted
   * Return: Boolean value representing success of deletion.
   */
  public Boolean delete(Entry e);

  /*
   * Name: update
   * Purpose: This uses the key that is part of every object to identify the
   * place that the passed in entry is in the database and overwrites it
   * with the content of the passed in object. Returns true if update is 
   * succesful and false if not.
   * Parameters: Entry e that will be updated.  
   * Return: Boolean value representing success of update.
   */
  public Boolean update(Entry e);

  /*
   * Name: list
   * Purpose: This method returns an ArrayList of entries that can be
   * used to populate the Table for the main entries view. Entries are
   * returned in reverse chronological order (newer first). The 1st parameter 
   * is the size of the list that should be returned. A size of 0 will return
   * all the entries. The offset parameter offsets the items that are returned.
   * So if you pass in (5, 2) then list will return an ArrayList of size five
   * starting at the third element in reverse chronological order.
   * Parameters: int size and offset
   * Return: ArrayList of Entries
   */
  public ArrayList<Entry> list(int size, int offset);

  /*
   * Name: search
   * Purpose: This takes a string, int and offset. It functions similarly
   * to the list function but searches the title field and returns matched
   * results.
   * Parameters: search string int size and offset
   * Return: ArrayList of Entries
   */
  public ArrayList<Entry> search(String search_terms, int size, int offset)

} 