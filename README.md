# Homework-Assignment-Refactoring-MonolithicAdventureGame-Using-SOLID-Principles
Refactoring MonolithicAdventureGame Using SOLID Principles

Introduction

This document provides an overview of the refactoring process for the MonolithicAdventureGame, focusing on applying SOLID principles to improve maintainability, flexibility, and scalability.
Applying SOLID Principles
1. Single Responsibility Principle (SRP)
Before: The original MonolithicAdventureGame class handled player management, combat, items, and level progression all in one place.
After:
Player class manages health, experience, and inventory.
CombatManager handles battle logic.
Enemy class represents different enemies.
Item class manages individual game items.
LevelManager is responsible for level progression.
2. Open/Closed Principle (OCP)
Before: Adding new enemy types required modifying the existing combat logic.
After: Introduced an IAttackable interface, allowing new enemy types to be added without modifying the combat system.
3. Liskov Substitution Principle (LSP)
Before: Enemy behavior was rigid and tightly coupled to a single implementation.
After: Enemy subclasses like Goblin and Vampire can be used interchangeably within the combat system without breaking functionality.
4. Interface Segregation Principle (ISP)
Before: A single, large class handled multiple responsibilities, leading to unnecessary dependencies.
After: Introduced separate interfaces: IAttackable, IDamageable, and IItemInteractable to segregate concerns.
5. Dependency Inversion Principle (DIP)
Before: The combat system directly depended on concrete enemy classes.
After: CombatManager now interacts with enemies via the IAttackable interface, reducing dependency on specific implementations.
