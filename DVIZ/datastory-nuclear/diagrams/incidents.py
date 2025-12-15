import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm

# Load the dataset
df = pd.read_csv('./data/Nuclear_Incidents_-_Sheet3.csv')

# --- 1. Data Cleaning and Preparation for Chart ---

# Clean column names
df.columns = df.columns.str.replace(' ', '', regex=False).str.replace('\n', '', regex=False).str.strip()

# Clean and convert death columns to numeric
# 1a. Handle 'NumbersofInDirectDeaths' by removing commas and converting to float
df['NumbersofInDirectDeaths'] = df['NumbersofInDirectDeaths'].fillna('0').astype(str).str.replace(',', '', regex=False)
df['NumbersofInDirectDeaths'] = pd.to_numeric(df['NumbersofInDirectDeaths'], errors='coerce').fillna(0)

# 1b. Handle 'NumbersofDirectDeaths'
df['NumbersofDirectDeaths'] = pd.to_numeric(df['NumbersofDirectDeaths'].fillna(0), errors='coerce').fillna(0)

# 1c. Calculate Total Deaths
df['Total_Deaths'] = df['NumbersofDirectDeaths'] + df['NumbersofInDirectDeaths']

# 1d. Extract Year
df['Date'] = pd.to_datetime(df['Date'], format='%d/%m/%Y', errors='coerce')
df['Year'] = df['Date'].dt.year.astype('Int64')

# 1e. Aggregate Total Deaths by Year
df_yearly_deaths = df.groupby('Year')['Total_Deaths'].sum().reset_index()
df_yearly_deaths = df_yearly_deaths.sort_values(by='Year')


# --- 2. Custom Font Setup (For your local environment) ---

# 🛑 ACTION REQUIRED: REPLACE THIS WITH THE ACTUAL PATH TO YOUR .ttf or .otf FILE
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


# --- 3. Styling Variables (from your CSS) ---
BLACK = '#000000'
ORANGE = '#ffaa00'


# --- 4. Matplotlib Style Configuration ---

plt.rcParams.update({
    'font.family': CUSTOM_FONT_NAME, 
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

    # Line Style
    'lines.linewidth': 4,
    'lines.color': ORANGE,
})

# --- 5. Plot Generation (Line Chart of Deaths Over Time) ---

fig, ax = plt.subplots(figsize=(16, 9))

# Plot the data as a line chart with markers
ax.plot(
    df_yearly_deaths['Year'], 
    df_yearly_deaths['Total_Deaths'], 
    color=ORANGE,
    marker='o', 
    markersize=8,
    markerfacecolor=ORANGE,
    markeredgecolor=BLACK,
    linestyle='-'
)

# Set title and labels
ax.set_title(
    'total deaths in reported nuclear incidents',
    fontsize=48, # Approx h3 size
    pad=20,
    loc='left'
)
ax.set_xlabel(
    'Year of Incident',
    fontsize=28, # Approx h4 size
    labelpad=15
)
ax.set_ylabel(
    'Total Deaths (Direct and Indirect)',
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

# Add grid lines
ax.grid(axis='y')

# Ensure y-axis starts at 0
ax.set_ylim(bottom=0)

# Use integer ticks for the x-axis (Years)
ax.xaxis.get_major_locator().set_params(integer=True)
plt.xticks(rotation=45, ha='right')

# Adjust layout and save with transparent background
plt.tight_layout()
plt.savefig('./nuclear_incidents_deaths_by_year_transparent.png', transparent=True)