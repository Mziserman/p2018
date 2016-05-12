import random

from combat import Combat


class Character(Combat):
	attack_limit = 10
	experience = 0
	level = 1
	base_hit_points = 10

	def attack(self):
		roll = random.randint(1, self.attack_limit)
		if self.weapon == 'sword':
			roll += 1
		elif self.weapon == 'axe':
			roll += 2
		return roll > 4

	def get_weapon(self):
		weapon = input("Choose your weapon : [S]word, [A]xe, [B]ow: ").lower()

		if weapon in 'sab':
			if weapon == 's':
				return 'sword'
			elif weapon == 'a':
				return 'axe'
			else:
				return 'bow'
		else:
			return self.get_weapon()

	def __init__(self, **kwargs):
		self.name = input("What's your name: ")
		self.weapon = self.get_weapon()
		self.hit_points = self.base_hit_points

		if kwargs is not None:
			for key, value in kwargs.items():
				setattr(self, key, value)

	def __str__(self):
		return '{}, HP: {}, XP: {}'.format(self.name, self.hit_points, self.experience)

	def rest(self):
		if self.hit_points < self.base_hit_points:
			self.hit_points += 1

	def add_experience(self, experience):
		self.experience += experience
		if self.leveled_up():
			self.level += 1
			self.experience = 0

	def leveled_up(self):
		return self.experience >= 5