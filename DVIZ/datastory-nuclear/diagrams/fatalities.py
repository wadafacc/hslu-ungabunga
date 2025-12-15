import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm

# --- 1. Custom Font Registration ---

# 🛑 ACTION REQUIRED: REPLACE THIS WITH THE ACTUAL PATH TO YOUR .ttf or .otf FILE
# Example: font_path = 'C:/Windows/Fonts/InstrumentSerif-Regular.ttf'
font_path = '/path/to/InstrumentSerif-Regular.ttf' 

# Register the font with Matplotlib
try:
    font_prop = fm.FontProperties(fname=font_path)
    fm.fontManager.addfont(font_path) 
    CUSTOM_FONT_NAME = font_prop.get_name()
except FileNotFoundError:
    # Fallback if the path is incorrect
    CUSTOM_FONT_NAME = 'serif' 
    print("Warning: Custom font file not found. Falling back to 'serif'.")


# --- 2. Data Loading and Preparation ---

df = pd.read_csv('./data/death-rates-from-energy-production-per-twh.csv')

# Rename for simplicity and sort by death rate (ascending)
df_sorted = df.rename(columns={'Deaths per TWh of electricity production': 'Deaths_per_TWh'})
df_sorted = df_sorted.sort_values(by='Deaths_per_TWh', ascending=True)


# --- 3. Styling Variables (from your CSS) ---
BLACK = '#000000'
ORANGE = '#ffaa00'


# --- 4. Matplotlib Style Configuration ---

plt.rcParams.update({
    'font.family': 'serif',
    'axes.edgecolor': BLACK,
    'axes.labelcolor': BLACK,
    'xtick.color': BLACK,
    'ytick.color': BLACK,
    'text.color': BLACK,

    # Transparency settings
    'figure.facecolor': 'none', 
    'axes.facecolor': 'none',   

    # Grid
    'grid.color': BLACK,
    'grid.linestyle': '--',
    'grid.alpha': 0.5,
})


# --- 5. Plot Generation (Horizontal Bar Chart) ---

fig, ax = plt.subplots(figsize=(16, 9))

# Create the horizontal bar chart
bars = ax.barh(
    df_sorted['Entity'], 
    df_sorted['Deaths_per_TWh'], 
    color=ORANGE
)

# Set title and labels
ax.set_title(
    'deaths per TWh of electricity',
    fontsize=48, # Approx h3 size
    pad=20,
    loc='left'
)
ax.set_xlabel(
    'Deaths per TWh of electricity production',
    fontsize=28, # Approx h4 size
    labelpad=15
)
ax.set_ylabel(
    'Energy Source',
    fontsize=28, # Approx h4 size
    labelpad=15
)

# Set tick label sizes
ax.tick_params(axis='both', which='major', labelsize=20)

# Customize spines (axes lines)
ax.spines['right'].set_visible(False)
ax.spines['top'].set_visible(False)
ax.spines['left'].set_linewidth(2)
ax.spines['bottom'].set_linewidth(2)

# Add grid lines only on the x-axis
ax.grid(axis='x')

# Add values to the end of the bars (data labels)
for bar in bars:
    ax.text(
        bar.get_width() + 0.1, # X-position is the end of the bar + small offset
        bar.get_y() + bar.get_height()/2, # Y-position is the center of the bar
        f'{bar.get_width():.3g}', # Format the value (e.g., 0.019, 4.63, 32.7)
        va='center', # Align vertically to the center
        ha='left',   # Align horizontally to the left of the text
        fontsize=20,
        color=BLACK,
        fontweight='bold'
    )
    
# Adjust x-axis limit to make space for the data labels
ax.set_xlim(right=df_sorted['Deaths_per_TWh'].max() * 1.15)


# Adjust layout and save with transparent background
plt.tight_layout()
plt.savefig('./death_rates_energy_production_transparent.png', transparent=True)