package com.avega.company.daoImpl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.avega.company.dao.SkillDao;
import com.avega.company.exception.SkillNotFoundException;
import com.avega.company.pojo.Skill;

public class SkillDaoImpl implements SkillDao {

	ConcurrentHashMap<String, Skill> skills = new ConcurrentHashMap<>();

	@Override
	public List<Skill> getAllSkills() {
		return (List<Skill>) skills.values();
	}

	@Override
	public Skill getSkill(String id) throws SkillNotFoundException {
		Skill sk = null;
		for (Skill skill : skills.values()) {
			if (skill.getSkillId().equalsIgnoreCase(id))
				sk = skill;
		}
		if (sk == null) {
			throw new SkillNotFoundException();
		}
		return sk;
	}

	@Override
	public Skill getSkillByName(String name) {
		for (Skill skill : skills.values()) {
			if (skill.getSkillName().equalsIgnoreCase(name)) {
				return skill;
			}
		}
		return null;
	}

	@Override
	public boolean addSkill(Skill skill) {
		boolean isAdd = false;
		skills.put(skill.getSkillId(), skill);
		if (skills.containsValue(skill))
			isAdd = true;
		return isAdd;
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		return skills.remove(skill.getSkillId(), skill);
	}

	@Override
	public Skill updateSkill(Skill skill) {
		Skill update = skills.get(skill.getSkillId());
		update.setSkillName(skill.getSkillName());
		return update;
	}

}
