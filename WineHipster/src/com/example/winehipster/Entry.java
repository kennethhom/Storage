package com.example.winehipster;

import java.util.Date;
import java.util.UUID;

import android.location.Location;

import com.google.android.gms.plus.model.people.Person.Image;

/**
 * @author Kenneth
 *
 */

/*
 * The Entry class will represent "entries" that the user has
 * entered into the Journal. It will contain all the items that the user
 * has entered with components stored in local variables. Further all 
 * validation of user input happens inside this class, but will throw 
 * exceptions that should be cought by the calling class.  
 *
 * Note: In the actual implementation this will have to be a nested class
 * so that Journal can access it's private variables. 
 */
public class Entry {

  /*
   * This is a list of all the local variables for an entry. Each has an
   * accompanied comment explaining if any validation occurs and which
   * have getters and setters. Getter and setters will not be explicitly 
   * written out inside this header file however they are needed. All
   * getters and setters will be the standard getObject() and setObject().
   * Some of the setObject methods will throw exceptions if the input
   * is not valid, these will be noted. Some methods, which are
   * also noted, do not have setters but all should have setters.
   *
   * The values stored here should map _directly_ to the table in the database.
   *
   * Note: When I say validation or error checking, I mean checking to make
   * sure that the value is within the proper range.
   */

  /*
   * Description
   * This is the vintage of the wine, it should be a year and it can not 
   * take place in the future. After a quick google search, it seems reasonable
   * to limit these values to 1700 to the present day. If the value entered
   * is negative or out of range and exception is thrown. 
   *
   * Settter: yes
   * Getter:  yes
   * Throws Exception: yes
   */
  private int vintage;

  /*
   * Description: This is the rating for the wine, it is on a five star system 
   * so it is an int limited to the range 0-5. A 0 is counted as not rated,
   * so there is no such thing as a 0 rating, 0 is just the default value
   * that indicated no rating has been set. If the value supplied is out
   * of range an exception is thrown.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: yes
   */
  private int rating;

  /*
   * Description: This is the price it should be displayed with precision of
   * 2 for the cents, along with a $. Value must be positive, throws an 
   * exception if the value is negative.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: yes
   */
  private float price;

  /*
   * Description: This is the alcohol, it is also a value that should display
   * with two decimal points. Can not be negative, exception if it is.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: yes
   */
  private float alcohol_content;

  /*
   * Description: This is the name of the wine.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private String wine;

  /*
   * Description: This is the type of the wine (red, white, Rose etc..).
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private String type;

  /*
   * Description: This is the place of origination for the wine. No validation
   * is done.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private String country_region;

  /*
   * Description: Serving temperature there should only be two 
   * options here: chilled or room temp. User must choose one, so no 
   * error checking.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private String serving_temperature;

  /*
   * Description: This is the way that the wine looks, no validation.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private String appearance;

  /*
   * Description: Way the wine smells, no validation.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private String aroma;

  /*
   * Description: Way the wine tastes, no validation.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private String taste;

  /*
   * Description: This is a field where the _user_ can enter food
   * that goes well with the wine. No validation.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private String paired_with;

  /*
   * Description: This is a place where the user can store how they felt about
   * the wine in their own words.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private String opinion;

  /*
   * Description: This is a boolean value to indicate if it is a draft. This
   * will be set to move items from the draft view to the main entry view.
   * This will be used in the Journal class where a SQL query where find all
   * the entries for the view based on this bool. So when the entry screen
   * saves or save draft is chosen this needs to be changed accordingly. 
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private Boolean is_draft;

  /*
   * Description: This should be found automatically when the entry is created
   * using the android geolocation API. If no location can be found then 
   * this is set to NULL and no location will be displayed. 
   * 
   * Setter: no
   * Getter: yes
   * Throws Exception: no
   */
  private Location entry_location;

  /*
   * Description: This is the unique key generated in the constructor. It
   * is not shown to the user and should never be changed. This is the 
   * way the database knows which entry is which.
   * 
   * Setter: no
   * Getter: yes
   * Throws Exception: no
   */
  private UUID db_key;

  /*
   * Description: This is the date that the entry was started. This is to
   * be automatically retrieved from the system and not modified.
   * 
   * Setter: no
   * Getter: yes
   * Throws Exception: no
   */
  private Date entry_date;

  /*
   * Description: This is the photo that the user can optionally take of
   * the wine. It will be downscaled (probably) and stored in the SQL 
   * database. No validation.
   * 
   * Setter: yes
   * Getter: yes
   * Throws Exception: no
   */
  private Image photo;
  

  /*
   * This is the public constructor for the Entry class. Upon instantiation
   * the only thing it has to do is generate a universally unique ID (UID).
   * The UUID is used as the primary key for storage inside the database, 
   * although the database code is not in this class, we need the UID so that
   * we can identify the objecy for updates to the database. Also, depending 
   * on if things will by default be saved in drafts or entries, this method
   * may want to change the Boolean is_draft.
   */
  public Entry() {
}
} 