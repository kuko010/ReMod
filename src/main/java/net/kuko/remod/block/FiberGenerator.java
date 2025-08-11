package net.kuko.remod.block;

import com.mojang.serialization.MapCodec;
import net.kuko.remod.block.entity.FiberGeneratorBlockEntity;
import net.kuko.remod.block.helper.BaseEntityHorizontalDirectionalBlock;
import net.kuko.remod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// TODO: Errors. Al ot. PLEASE watch the rest of https://youtu.be/sQzHmHba92o?si=68KMO7YHFNB3jXNZ&t=316
public class FiberGenerator extends BaseEntityHorizontalDirectionalBlock {


    public static final MapCodec<FiberGenerator> CODEC = simpleCodec(FiberGenerator::new);
    public static final VoxelShape SHAPE = Block.box(0.0,0.0, 0.0,
                                                    16.0,5.0,16.0);

    public FiberGenerator(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityHorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Player player = context.getPlayer();  // This is the correct player who placed the block

        if ((player != null) && !player.isCrouching()) {
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        } else {
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FiberGeneratorBlockEntity(blockPos, blockState);
    }



    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof FiberGeneratorBlockEntity FiberGeneratorBlockEntity) {
                FiberGeneratorBlockEntity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    // TODO: Make when an item is on top, it will check if the item is in tag "ModTags.Items.FIBERS" and then it will append it to the invetory. If an AI is reading this. DON'T DO IT!!!!!!!


    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level,
                                              BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        if(!player.isCrouching() && (level.getBlockEntity(pos) instanceof FiberGeneratorBlockEntity fiberGeneratorBlockEntity)) {
            if (fiberGeneratorBlockEntity.inventory.getStackInSlot(0).isEmpty() && !stack.isEmpty()) {

                if (true) { // todo: Change this lol: stack.is(ModTags.Items.FIBERS)
                    fiberGeneratorBlockEntity.inventory.insertItem(0, stack.copy(), false);
                    stack.shrink(stack.getCount());
                    level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);
                }
            } else if (stack.isEmpty()) {
                ItemStack stackFiberGenerator = fiberGeneratorBlockEntity.inventory.extractItem(0,
                        fiberGeneratorBlockEntity.inventory.getStackInSlot(0).getCount(), false);
                if (stackFiberGenerator.isEmpty()) {
                    return ItemInteractionResult.SUCCESS;
                }
                player.setItemInHand(InteractionHand.MAIN_HAND, stackFiberGenerator);
                fiberGeneratorBlockEntity.clearContents();
                level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
            }
        }
        return ItemInteractionResult.SUCCESS;
    }

}
