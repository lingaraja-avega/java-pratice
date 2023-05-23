package com.avega.company.pojo;

public class Skill {

	private String skillId;
	private String skillName;

	public Skill() {
	}

	public Skill(String skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;

	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
