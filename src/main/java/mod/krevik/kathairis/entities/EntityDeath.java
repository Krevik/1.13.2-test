package mod.krevik.kathairis.entities;


/*public class EntityDeath extends EntityMob
{
	/*private boolean defeated;
	public boolean isFighting;
    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenSky(false);
    private static final DataParameter<Integer> scytheAttackTimer = EntityDataManager.createKey(EntityDeath.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> isUsingSomeAttack = EntityDataManager.createKey(EntityDeath.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> dissolutionAttackTimer = EntityDataManager.createKey(EntityDeath.class, DataSerializers.VARINT);

    public EntityDeath(World worldIn)
    {
        super(worldIn);
        this.setSize(1.25F, 4F);
        defeated=false;
        isFighting=false;
        getDataManager().set(scytheAttackTimer,-1);
        getDataManager().set(isUsingSomeAttack,false);
        getDataManager().set(dissolutionAttackTimer,-1);

    }
    
    @Override
    public boolean canDespawn()
    {
        return false;
    }

    protected void initEntityAI()
    {
        this.experienceValue=1000;
        this.applyEntityAI();
    }
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    protected void applyEntityAI()
    {
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));

    }
    

    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000.0D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(500);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8F);


    }

    protected void registerData()
    {
        super.registerData();
        this.getDataManager().register(scytheAttackTimer, Integer.valueOf(-1));
        this.getDataManager().register(isUsingSomeAttack, false);
        this.getDataManager().register(dissolutionAttackTimer, Integer.valueOf(-1));

    }


    protected int getExperiencePoints(EntityPlayer player)
    {
        return super.getExperiencePoints(player);
    }

    public void notifyDataManagerChange(DataParameter<?> key)
    {
        super.notifyDataManagerChange(key);
    }


    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        super.setEquipmentBasedOnDifficulty(difficulty);
    }
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setEquipmentBasedOnDifficulty(difficulty);
        return livingdata;
    }
    public boolean attackEntityAsMob(Entity entityIn)
    {
        if(getIsUsingSomeAttack()){
            if(getScytheAttackTimer()>-1&&getScytheAttackTimer()<30){
                return super.attackEntityAsMob(entityIn);
            }
        }
        return false;
    }

    int mode=0;
    KathairisDataStorage data;
    @Override public void tick() {
    	super.tick();
	    	if(data==null) {
	    		data= KathairisDataStorage.getDataInstance(world);
	    	}
    	if(data!=null) {
    	    isFighting=data.getIsDeathFighting();
            if(isFighting) {

            }
            if(getAttackTarget()!=null){
                if(mode==0){

                }
            }
    	}

    	if(!getIsUsingSomeAttack()){
            if(getRNG().nextInt(100)==0){
                getDataManager().set(scytheAttackTimer,90);
            }
        }
        if(getDataManager().get(scytheAttackTimer)>=0){
            getDataManager().set(scytheAttackTimer, getDataManager().get(scytheAttackTimer) -1);
        }
        if(getDataManager().get(dissolutionAttackTimer)>=0){
            getDataManager().set(dissolutionAttackTimer, getDataManager().get(dissolutionAttackTimer) -1);
        }

        if((getDataManager().get(scytheAttackTimer)!=-1||getDataManager().get(dissolutionAttackTimer)!=-1)){
            getDataManager().set(isUsingSomeAttack,true);
        }else{
            getDataManager().set(isUsingSomeAttack,false);
        }
    }

    public boolean getIsUsingSomeAttack(){
        return getDataManager().get(isUsingSomeAttack);
    }
    public int getScytheAttackTimer(){
        return getDataManager().get(scytheAttackTimer);
    }
    public int getDissolutionAttackTimer(){
        return getDataManager().get(dissolutionAttackTimer);
    }


    public boolean attackEntityFrom(DamageSource source, float amount)
    {
    	if(isFighting) {
    		if(source.getTrueSource() instanceof EntityPlayer) {
    			EntityPlayer attacker = (EntityPlayer) source.getTrueSource();
            	Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(attacker.getHeldItemMainhand());
    			if(map.containsKey(KathairisEnchantments.Ethereal)) {
    				return super.attackEntityFrom(source,amount);
    			}
    		}
    	}
    	return false;
    }

    protected SoundEvent getAmbientSound()
    {
        return KCore.proxy.death_living;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return null;
    }

    protected SoundEvent getDeathSound()
    {
        return null;
    }

    protected SoundEvent getStepSound()
    {
        return null;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    /*public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return null;
    }

    public static void registerFixesHowler(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityDeath.class);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    /*public void writeAdditional(NBTTagCompound compound)
    {
        super.writeAdditional(compound);
        compound.setBoolean("defeated", defeated);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    /*public void readAdditional(NBTTagCompound compound)
    {
        super.readAdditional(compound);
        defeated=compound.getBoolean("defeated");
        if (this.hasCustomName())
        {
            this.bossInfo.setName(this.getDisplayName());
        }
    }
    
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	if(!isFighting) {
        player.openGui(KCore.instance, KCore.GUI_ENUM.DEATH.ordinal(), 
                player.world, 
                (int)player.posX, 
                (int)player.posY, 
                (int)player.posZ); 
    	}
        return super.processInteract(player, hand);

    }

    /**
     * This method gets called when the entity kills another one.
     */
   /* public void onKillEntity(EntityLivingBase entityLivingIn)
    {
        isFighting=false;
        defeated=true;
        PacketDeathHandlerServer message = new PacketDeathHandlerServer(true,false,true);
        KathairisPacketHandler.CHANNEL.sendToServer(message);
        super.onKillEntity(entityLivingIn);

    }

    protected boolean canEquipItem(ItemStack stack)
    {
        return false;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    /*public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);
    }

}*/