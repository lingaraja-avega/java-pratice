package com.avega.company.dao;

import java.util.List;

import com.avega.company.exception.SkillNotFoundException;
import com.avega.company.pojo.Skill;

public interface SkillDao {

	List<Skill> getAllSkills();

	Skill getSkill(String id) throws SkillNotFoundException;
	
	Skill getSkillByName(String name);

	boolean addSkill(Skill skill);

	boolean deleteSkill(Skill skill);

	Skill updateSkill(Skill skill);
}
