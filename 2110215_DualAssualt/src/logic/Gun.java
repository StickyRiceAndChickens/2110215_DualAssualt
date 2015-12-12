package logic;

import java.awt.List;
import java.util.ArrayList;

import render.InputUtility;
import render.RenderableHolder;

public class Gun extends Weapon {

	private Human shooter;
	private int gunType;
	private int fireRate;
	private int fireRateCount;
	private int fireRateDelay;
	private int magazine;
	private int defaultMagazine;
	private int ammo;
	private int power;
	private int reloadingTime;
	private int reloadingCount;

	public Gun(int x, int y, int radius, int angle, Human shooter, int gunType) {
		super(x, y, radius, angle);
		// TODO Auto-generated constructor stub
		this.gunType = gunType;
		switch (gunType) {
		case 0:
			this.fireRate = 35;
			this.magazine = 8;
			this.ammo = 42;
			this.power = 10;
			this.reloadingTime = 30;
			break;
		case 1:
			this.fireRate = 50;
			this.magazine = 20;
			this.ammo = 120;
			this.power = 2;
			this.reloadingTime = 10;
			break;
		}
		this.fireRateDelay = 60 - fireRate;
		this.shooter = shooter;
		this.fireRateCount = 0;
		this.reloadingTime = 0;
		this.defaultMagazine = magazine;

	}

	public void setShooter(Human shooter) {
		this.shooter = shooter;
	}

	public int getAmmo() {
		return ammo;
	}

	public void pickUpAmmo() {
		switch (gunType) {
		case 0:
			ammo += 2;
			break;

		default:
			ammo += 10;
			break;
		}
	}

	public Human getShooter() {
		return shooter;
	}

	public int getMagazine() {
		return magazine;
	}

	private boolean hasMagazine() {
		if (this.magazine > 0)
			return true;
		else {
			magazine = 0;
			return false;
		}
	}

	private boolean hasAmmo() {
		if (this.ammo > 0)
			return true;
		else {
			ammo = 0;
			return false;
		}
	}

	public boolean reload() {
		switch (gunType) {
		case 0:
			if (magazine < defaultMagazine) {
				if (ammo > 0) {
					if (reloadingCount < reloadingTime) {
						reloadingCount++;
						return true;
					}

					reloadingCount = 0;
					magazine++;
					ammo--;
				} else
					return false;
			}

			return false;
		default:
			if (reloadingCount < reloadingTime) {
				reloadingCount++;
				return true;
			}

			ammo += this.magazine;
			if (ammo >= defaultMagazine) {
				magazine = defaultMagazine;
				ammo -= defaultMagazine;
			} else {
				magazine = ammo;
				ammo = 0;
			}
			reloadingCount = 0;
			return false;
		}

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		x = shooter.getX();
		y = shooter.getY();
		angle = shooter.getAngle();
	}

	@Override
	public void attack() {
		// add new Bullet

		if (hasAmmo()) {
			if (hasMagazine()) {
				reloadingCount = 0;
				if (fireRateCount < fireRateDelay) {
					return;

				}

				Bullet bullet = new Bullet(x, y, angle, power, 4, shooter);
				GameLogic.addEntity(bullet);
				RenderableHolder.getInstance().add(bullet);
				
			}
			fireRateCount = 0;
			magazine--;
			ammo--;
			hasAmmo();
			hasMagazine();
		} else {
			fireRateCount = 0;
			while (reload() || InputUtility.getKeyTriggered(((Player) shooter).getButton(5)))
				;
		}
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		move();
		fireRateCount++;

	}

}
