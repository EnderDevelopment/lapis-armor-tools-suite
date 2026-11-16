# Minecraft Plugin: Lapis Armor & Tools Suite

Lapis Armor & Tools Suite is a Minecraft plugin that adds a complete lapis lazuli equipment set, including dyed leather armor, diamond-based tools with lapis-themed names and metadata, crafting recipes, and the `/lapisgear` command for receiving the full set.

## Install

1. Use a Paper server running Minecraft 1.21.11 or a compatible 1.21 server.
2. Install Java 21.
3. Build the plugin with Maven:

```bash
mvn clean package
```

4. Copy the generated `target/plugin.jar` file into the server's `plugins` directory.
5. Start or restart the server.
6. Confirm that `LapisGear` loads successfully.

## Use

Craft the equipment using the following recipes:

- Armor uses lapis lazuli and produces dyed leather armor.
- Tools use lapis lazuli blocks and sticks, following sword, pickaxe, axe, shovel, and hoe patterns.

Players with the `lapisgear.give` permission can run:

```text
/lapisgear
```

The command gives the player the complete set:

- Lapis Lazuli Helmet
- Lapis Lazuli Chestplate
- Lapis Lazuli Leggings
- Lapis Lazuli Boots
- Lapis Lazuli Sword
- Lapis Lazuli Pickaxe
- Lapis Lazuli Axe
- Lapis Lazuli Shovel
- Lapis Lazuli Hoe

The `lapisgear.give` permission defaults to server operators. The command can only be used by players.

---

More Minecraft plugin projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/4abd5b41-73fc-419b-a842-c5a9c7b2dd78?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=4abd5b41-73fc-419b-a842-c5a9c7b2dd78
