package com.vee.sample.gwt.client.data;

import java.util.Date;

import com.google.gwt.view.client.ProvidesKey;
import com.vee.sample.gwt.client.data.ContactDatabase.Category;

/**
 * Information about a contact.
 */
public class ContactInfo implements Comparable<ContactInfo> {

  /**
   * The key provider that provides the unique ID of a contact.
   */
  public static final ProvidesKey<ContactInfo> KEY_PROVIDER = new ProvidesKey<ContactInfo>() {
    public Object getKey(ContactInfo item) {
      return item == null ? null : item.getId();
    }
  };

  private static int nextId = 0;

  private String address;
  private int age;
  private Date birthday;
  private Category category;
  private String firstName;
  private final int id;
  private String lastName;

  public ContactInfo(Category category) {
    this.id = nextId;
    nextId++;
    setCategory(category);
  }

  public int compareTo(ContactInfo o) {
    return (o == null || o.firstName == null) ? -1 : -o.firstName.compareTo(firstName);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ContactInfo) {
      return id == ((ContactInfo) o).id;
    }
    return false;
  }

  /**
   * @return the contact's address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @return the contact's age
   */
  public int getAge() {
    return age;
  }

  /**
   * @return the contact's birthday
   */
  public Date getBirthday() {
    return birthday;
  }

  /**
   * @return the category of the conteact
   */
  public Category getCategory() {
    return category;
  }

  /**
   * @return the contact's firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the contact's full name
   */
  public final String getFullName() {
    return firstName + " " + lastName;
  }

  /**
   * @return the unique ID of the contact
   */
  public int getId() {
    return this.id;
  }

  /**
   * @return the contact's lastName
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public int hashCode() {
    return id;
  }

  /**
   * Set the contact's address.
   * 
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Set the contact's birthday.
   * 
   * @param birthday the birthday
   */
  @SuppressWarnings("deprecation")
  public void setBirthday(Date birthday) {
    this.birthday = birthday;

    // Recalculate the age.
    Date today = new Date();
    this.age = today.getYear() - birthday.getYear();
    if (today.getMonth() > birthday.getMonth()
        || (today.getMonth() == birthday.getMonth() && today.getDate() > birthday.getDate())) {
      this.age--;
    }
  }

  /**
   * Set the contact's category.
   * 
   * @param category the category to set
   */
  public void setCategory(Category category) {
    assert category != null : "category cannot be null";
    this.category = category;
  }

  /**
   * Set the contact's first name.
   * 
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Set the contact's last name.
   * 
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
