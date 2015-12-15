package logic;

import java.awt.List;
import java.util.ArrayList;

import render.InputUtility;
import render.RenderableHolder;

public class Gun extends Weapon {

	private Human shooter;
	private int gunType;
	private int fireRateCount;
	private int fireRateDelay;
	private int magazine;
	private int defaultMagazine;
	private int ammo;
	private int power;
	private int reloadingTime;
	private int reloadingCount;
	private boolean isReloading = false;
	private boolean isShoot = false;

	public Gun(int x, int y, int angle, Human shooter, int gunType) {
		super(x, y, 0,0, angle);
		// TODO Auto-generated constructor stub
		this.gunType = gunType;
		switch (gunType) {
		case 0:
			//shotgun
			this.fireRateDelay = 5;
			this.magazine = 8;
			this.ammo = 300;
			this.power = 10;
			this.reloadingTime = 50;
			break;
		case 1:
			//rifle
			this.fireRateDelay = 3;
			this.magazine = 20;
			this.ammo = 520;
			this.power = 4;
			this.reloadingTime = 30;
			break;
		case 3:
			this.fireRateDelay=20;
			this.magazine=8;
			this.power=3;
			this.ammo=5000;
			this.reloadingTime=30;
		}

		this.shooter = shooter;
		this.fireRateCount = 0;
		this.reloadingCount = 0;
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

	public void reload() {

		ammo += this.magazine;
		if (ammo >= defaultMagazine) {
			magazine = defaultMagazine;

		} else {
			magazine += ammo;

		}

		return;

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
				isShoot = true;
				return;

			} else {
				isReloading = true;

			}
		}
	}

	public String getStatus() {
		if (isReloading)
			return "Reloading";
		else
			return "nothing";
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		move();

		if (isShoot) {
			fireRateCount++;
			if (fireRateCount == fireRateDelay) {
				fireRateCount = 0;
				isShoot = false;
				shoot();
			}
		}
		if (isReloading) {
			reloadingCount++;
			if (reloadingCount == reloadingTime) {
				reload();
				reloadingCount = 0;
				isReloading = false;
			}
		}
		if (shooter.isDestroy())
			this.isDestroy = true;
	}

	private void shoot() {
		// TODO Auto-generated method stub
		magazine--;
		ammo--;
		hasAmmo();
		hasMagazine();
		Bullet bullet = new Bullet(x, y, angle, power, 30, shooter);
		GameLogic.map.addEntity(bullet);
		RenderableHolder.getInstance().add(bullet);

	}
	
	public int getGunType() {
		return gunType;
	}

}
