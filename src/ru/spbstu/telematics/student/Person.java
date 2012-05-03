package ru.spbstu.telematics.student;

public class Person {
	private int id;
	private String name;
	private int age;
	private int friendId;
	
	public Person(int id, String name, int age, int friendId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.friendId = friendId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
}
