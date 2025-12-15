import pandas as pd
import matplotlib.pyplot as plt

# --- 1. Data Loading and Preparation ---

# Load the dataset
df = pd.read_csv('./data/share-electricity-nuclear.csv')

# Filter for the 'World' entity
df_world = df[df['Entity'] == 'World'].copy()

# Rename the percentage column for easier use
df_world.rename(columns={'Nuclear - % electricity': 'Nuclear_Share'}, inplace=True)


# --- 2. Styling Variables (from your CSS) ---
OFF_WHITE = '#fffef1'
BLACK = '#000000'
ORANGE = '#ffaa00'

# --- 3. Matplotlib Style Configuration ---

# Set up the plot style to mimic the CSS
plt.rcParams.update({
    # Use a generic serif font to approximate "Instrument Serif"
    'font.family': 'serif',

    # Colors
    'axes.edgecolor': BLACK,
    'axes.labelcolor': BLACK,
    'xtick.color': BLACK,
    'ytick.color': BLACK,
    'text.color': BLACK,
# Set facecolors to none for transparency
    'figure.facecolor': 'none', # Makes the entire figure background transparent
    'axes.facecolor': 'none',   # Makes the plot area background transparent

    # Grid (optional, but good for data)
    'grid.color': BLACK,
    'grid.linestyle': '--',
    'grid.alpha': 0.5,

    # Line Style
    'lines.linewidth': 4,
    'lines.color': ORANGE,
})


# --- 4. Plot Generation ---

fig, ax = plt.subplots(figsize=(16, 9))

# Plot the data
ax.plot(df_world['Year'], df_world['Nuclear_Share'], color=ORANGE, label='Nuclear Share')

# Set title and labels with large font sizes
ax.set_title(
    'world share of nuclear electricty',
    fontsize=48, # Approx h3 size
    pad=20,
    loc='left' # Aligning left as per the CSS section style
)
ax.set_xlabel(
    'Year',
    fontsize=28, # Approx h4 size
    labelpad=15
)
ax.set_ylabel(
    'Nuclear - % electricity',
    fontsize=28, # Approx h4 size
    labelpad=15
)

# Set tick label sizes
ax.tick_params(axis='both', which='major', labelsize=20)

# Add grid lines
ax.grid(True, axis='y')

# Customize the spine visibility and thickness
ax.spines['right'].set_visible(False)
ax.spines['top'].set_visible(False)
ax.spines['left'].set_linewidth(2)
ax.spines['bottom'].set_linewidth(2)

# Ensure y-axis starts at 0
ax.set_ylim(bottom=0)

# Add a subtle annotation for the latest value (mimicking some content style)
# latest_year = df_world['Year'].max()
# latest_share = df_world['Nuclear_Share'].iloc[-1]
# ax.text(
#     latest_year,
#     latest_share,
#     f'{latest_share:.2f}% ({latest_year})',
#     fontsize=20, # Smaller text size
#     color=ORANGE,
#     ha='right',
#     va='bottom',
#     fontweight='bold'
# )

# Adjust layout and save
plt.tight_layout()
plt.savefig('./nuclear_electricity_share_world_styled.png')