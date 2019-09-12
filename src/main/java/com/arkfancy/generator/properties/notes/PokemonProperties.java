package com.arkfancy.generator.properties.notes;

import com.arkfancy.generator.properties.GeneratorProperties;

public class PokemonProperties implements GeneratorProperties {

	@Override
	public String getTablePrefix() {
		return "pokemon_";
	}

	@Override
	public String[] getInclude() {
		return new String[] { "^pokemon_\\w+" };
	}

	@Override
	public String getParent() {
		return "com.arkfancy.notes";
	}

	@Override
	public String getSubModuleName() {
		return "pokemon";
	}

}
